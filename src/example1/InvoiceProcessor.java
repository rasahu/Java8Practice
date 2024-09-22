package example1;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.sql.*;
import java.util.concurrent.*;
import java.util.*;

// Invoice class to represent an invoice (you should modify this to match your format)
class Invoice {
    String id;
    String customer;
    double amount;

    // Constructor and getters/setters
    public Invoice(String id, String customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
    
}

// Main processing class
public class InvoiceProcessor {

    private static final int CHUNK_SIZE = 1024 * 1024 * 100; // 100MB chunks (adjust as needed)
    private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors(); // Adjust based on your system's capabilities

    // Thread pool for concurrent processing
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public void processLargeFile(String filePath, Connection dbConnection) throws IOException, InterruptedException {
        Path path = Paths.get(filePath);
        long fileSize = Files.size(path);
        long position = 0;
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
          

            List<Future<Void>> futures = new ArrayList<>();
            CompletableFuture<Void> completableFuture = null;

            // Split file into chunks
            while (position < fileSize) {
                long remaining = fileSize - position;
                long size = Math.min(CHUNK_SIZE, remaining);

                // Submit chunk to be processed by thread pool
                futures.add(executor.submit(new FileChunkProcessor(fileChannel, position, size, dbConnection)));
				/*
				 * CompletableFuture.supplyAsync(()->new
				 * FileChunkProcessor(fileChannel,position, size, dbConnection), executor);
				 */
                position += size;
            }

            // Wait for all threads to complete
            for (Future<Void> future : futures) {
                future.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    // Class to process a chunk of the file
    class FileChunkProcessor implements Callable<Void> {
        private final FileChannel fileChannel;
        private final long position;
        private final long size;
        private final Connection dbConnection;

        public FileChunkProcessor(FileChannel fileChannel, long position, long size, Connection dbConnection) {
            this.fileChannel = fileChannel;
            this.position = position;
            this.size = size;
            this.dbConnection = dbConnection;
        }

        @Override
        public Void call() throws Exception {
            ByteBuffer buffer = ByteBuffer.allocateDirect((int) size); // Memory-efficient allocation
            fileChannel.read(buffer, position);
            buffer.flip();

            processBuffer(buffer);

            return null;
        }

        // Process the buffer to extract and store invoices
        private void processBuffer(ByteBuffer buffer) throws SQLException {
            List<Invoice> invoices = new ArrayList<>();

            // Dummy parsing logic (adjust based on the actual format of your invoices)
            StringBuilder sb = new StringBuilder();
            while (buffer.hasRemaining()) {
                char c = (char) buffer.get(); // Read a character
                if (c == '\n') {
                    invoices.add(parseInvoice(sb.toString())); // Parse and add to list
                    sb.setLength(0); // Reset the StringBuilder
                } else {
                    sb.append(c);
                }
            }

            // Store invoices in the database in batches
            storeInvoicesInDB(invoices, dbConnection);
        }

        // Dummy method to parse an invoice (adjust based on your file format)
        private Invoice parseInvoice(String invoiceLine) {
            String[] parts = invoiceLine.split(",");
            return new Invoice(parts[0], parts[1], Double.parseDouble(parts[2]));
        }

        // Store invoices in the database in batches for efficiency
        private void storeInvoicesInDB(List<Invoice> invoices, Connection dbConnection) throws SQLException {
            String sql = "INSERT INTO invoices (id, customer, amount) VALUES (?, ?, ?)";
            try (PreparedStatement ps = dbConnection.prepareStatement(sql)) {
                for (Invoice invoice : invoices) {
                    ps.setString(1, invoice.getId());
                    ps.setString(2, invoice.getCustomer());
                    ps.setDouble(3, invoice.getAmount());
                    ps.addBatch();
                }
                ps.executeBatch(); // Execute in batch to reduce database calls
            }
        }
    }

    public static void main(String[] args) {
        try (Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicedb", "user", "password")) {
            InvoiceProcessor processor = new InvoiceProcessor();
            processor.processLargeFile("path_to_large_file.txt", dbConnection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
