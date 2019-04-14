package api.file.dupe;

import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.text.similarity.LevenshteinDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.List;



public class FileOperations {
    /**
        Contains the list of all customers in the csv file
     */
    private static List<Customer> customers;
    

    /**
     * @param file is the attached csv file
     * @return a list of duplicate entries and non-duplicate entries
     */
    public static List<List<String>> handleFile(MultipartFile file){
        customers = new ArrayList<Customer>();
        BufferedReader br;
        List<String> unique = new ArrayList<>();
        List<String> duplicates = new ArrayList<>();
        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            System.out.println("\nPotential Duplicates");
            line = br.readLine(); // Ignore first line i.e., column names
            while ((line = br.readLine()) != null) {
                String[] customerData = line.split(",");
                if(customerData.length < 12)
                    continue;
                Customer customer = new Customer(customerData);
                if(findDuplicates(customer)){
                    duplicates.add(line);
                    System.out.println(line);
                }
                else {
                    unique.add(line);
                }
                customers.add(customer);
            }
            System.out.println("\nNone Duplicates");
            for(String entry:unique)
                System.out.println(entry);


        } catch (IOException e) {
            System.err.println(e.getMessage());       
        }
        List<List<String>> result = new ArrayList<>();
        result.add(duplicates);
        result.add(unique);
        return result;
    }

    /**
     * @param customer is the customer data to be compared with the list of all entries stored so far
     * @return true if it is a duplicate entry, false otherwise
     */
    private static boolean findDuplicates(Customer customer) {
        for(Customer oldEntry:customers) {
            String[] nonNullValues = getCustomerStrings(oldEntry,customer);
            if(LevenshteinDistance.getDefaultInstance().apply(nonNullValues[0],nonNullValues[1]) < Integer.parseInt(nonNullValues[2]))
                {
                    return true;
                }
        }
        return false;
    }

    /**
     * @param old is the old customer entry that is compared with the current entry
     * @param customer is the current entry that is being evaluated
     * @return nonNullValues array contains two strings of non-null values for both the customer objects
     * @return nonNullValues also contains a third string that indicates the number of non-null values for both the customer objects
     */
    private static String[] getCustomerStrings(Customer old, Customer customer) {
        StringBuilder oldString = new StringBuilder();
        StringBuilder newString = new StringBuilder();
        String[] nonNullValues = new String[3];
        int threshold = 0;

        if(old.getFirstName().length() > 0 && customer.getFirstName().length() > 0) {
            oldString.append(old.getFirstName());
            newString.append(customer.getFirstName());
            threshold++;
        }
        if(old.getLastName().length() > 0 && customer.getLastName().length() > 0) {
            oldString.append(old.getLastName());
            newString.append(customer.getLastName());
            threshold++;
        }
        if(old.getCompany().length() > 0 && customer.getCompany().length() > 0) {
            oldString.append(old.getCompany());
            newString.append(customer.getCompany());
            threshold++;
        }
        if(old.getAddress1().length() > 0 && customer.getAddress1().length() > 0) {
            oldString.append(old.getAddress1());
            newString.append(customer.getAddress1());
            threshold++;
        }
        if(old.getAddress2().length() > 0 && customer.getAddress2().length() > 0) {
            oldString.append(old.getAddress1());
            newString.append(customer.getAddress1());
            threshold++;
        }
        if(old.getZip().length() > 0 && customer.getZip().length() > 0) {
            oldString.append(old.getZip());
            newString.append(customer.getZip());
            threshold++;
        }
        if(old.getCity().length() > 0 && customer.getCity().length() > 0) {
            oldString.append(old.getCity());
            newString.append(customer.getCity());
            threshold++;
        }
        if(old.getStateLong().length() > 0 && customer.getStateLong().length() > 0) {
            oldString.append(old.getStateLong());
            newString.append(customer.getStateLong());
            threshold++;
        }
        if(old.getState().length() > 0 && customer.getState().length() > 0) {
            oldString.append(old.getState());
            newString.append(customer.getState());
            threshold++;
        }
        if(old.getPhone().length() > 0 && customer.getPhone().length() > 0) {
            oldString.append(old.getPhone());
            newString.append(customer.getPhone());
            threshold++;
        }
        if(old.getEmail().length() > 0 && customer.getEmail().length() > 0) {
            oldString.append(old.getEmail());
            newString.append(customer.getEmail());
            threshold++;
        }
        nonNullValues[0] = oldString.toString();
        nonNullValues[1] = newString.toString();
        nonNullValues[2] = threshold + "";
        return nonNullValues;
    }

    public FileOperations() {
    }
}
