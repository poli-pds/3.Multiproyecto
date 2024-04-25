package co.com.poli.customerservice.controller;

import co.com.poli.customerservice.persistence.entity.Customer;
import co.com.poli.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping
    public Customer save(@RequestBody Customer customer){
        customerService.save(customer);
        return customer;
    }
    @DeleteMapping("/{nit}")
    public Customer delete(@PathVariable("nit") String nit){
        Customer customer = findByNit(nit);
        if(customer==null){
            return null;
        }
        customerService.delete(customer);
        return customer;
    }

    @GetMapping
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/nit/{nit}")
    public Customer findByNit(@PathVariable("nit") String nit){
        return customerService.findByNit(nit);
    }

    @GetMapping("/{id}")
    public Customer findByID(@PathVariable("id") Long id){
        return customerService.findById(id);
    }
}
