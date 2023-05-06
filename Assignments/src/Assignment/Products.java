package Assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Products {
    private int id;
    private String name;
    private double price;

    public Products(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static void main(String[] args) {
        ArrayList<Products> products = new ArrayList<Products>();
        String csvFile = "Product.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                StringTokenizer st = new StringTokenizer(line, cvsSplitBy);
                int id = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                double price = Double.parseDouble(st.nextToken());
                products.add(new Products(id, name, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // print product data to console
        for (Products p : products) {
            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
        }
    }
}
