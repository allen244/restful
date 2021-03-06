package com.avs.bootstrap;

import com.avs.domain.Category;
import com.avs.domain.Customer;
import com.avs.domain.Vendor;
import com.avs.repositories.CategoryRepository;
import com.avs.repositories.CustomerRepository;
import com.avs.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    public CategoryRepository categoryRepository;
    public CustomerRepository customerRepository;
    public VendorRepository vendorRepository;



    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();


        loadCustomers();

        loadVedors();
    }

    private void loadVedors() {
        Vendor vendor = new Vendor();
        vendor.setName("hello");

        Vendor vendor1 = new Vendor();
        vendor1.setName("hello222");

        Vendor vendor2 = new Vendor();
        vendor2.setName("hello33");

        vendorRepository.save(vendor);

        vendorRepository.save(vendor1);
        vendorRepository.save(vendor2);

        System.out.println("Data Loaded vendorRepository = " + vendorRepository.count() );
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");


        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);


        System.out.println("Data Loaded = " + categoryRepository.count() );
    }

    private void loadCustomers() {
        Customer susan = new Customer();
        susan.setFirstname("Susan");
        susan.setLastname("Tanner");
        susan.setCustomerUrl("/shop/customer/642");

        Customer mike = new Customer();
        mike.setFirstname("mike");
        mike.setLastname("smith");
        mike.setCustomerUrl("/shop/customer/444");

        customerRepository.save(susan);
        customerRepository.save(mike);

        System.out.println("Data Loaded = " + customerRepository.count() );
    }
}
