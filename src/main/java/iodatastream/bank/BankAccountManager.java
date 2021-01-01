package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount bankAccount, Path folder) {
        Path path = folder.resolve(bankAccount.getAccountNumber() + ".dat");
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            dataOutputStream.writeUTF(bankAccount.getAccountNumber());
            dataOutputStream.writeUTF((bankAccount.getOwner()));
            dataOutputStream.writeDouble(bankAccount.getBalance());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public BankAccount loadAccount(InputStream inputStream) {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream))) {
            return new BankAccount(dataInputStream.readUTF(), dataInputStream.readUTF(), dataInputStream.readDouble());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
