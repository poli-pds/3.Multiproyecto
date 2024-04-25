package co.com.poli.shoppingservice.controller;

import co.com.poli.shoppingservice.persistence.entity.Invoice;
import co.com.poli.shoppingservice.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppings")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping()
    public Invoice save(@RequestBody Invoice invoice) {
        invoiceService.save(invoice);
        return invoice;
    }

    @DeleteMapping("/{numberInvoice}")
    public Invoice delete(@PathVariable("numberInvoice") String numberInvoice) {
        Invoice invoice = invoiceService.findByNumberInvoice(numberInvoice);
        if (invoice == null) {
            return null;
        }
        invoiceService.delete(invoice);
        return invoice;
    }

    @GetMapping("/{numberInvoice}")
      public Invoice getByNumberInvoice(@PathVariable("numberInvoice") String numberInvoice) {
        Invoice invoice = invoiceService.findByNumberInvoice(numberInvoice);
        if (invoice == null) {
            return null;
        }
        return invoice;
    }
}
