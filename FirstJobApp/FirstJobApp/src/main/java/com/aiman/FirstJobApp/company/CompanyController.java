package com.aiman.FirstJobApp.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping
    public List<Company> listAllComapny(){
        return companyService.getAllCompany();
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        if(companyService.updateCompany(company,id)){
            return new ResponseEntity<>("UPdated", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Comapny Not found",HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping()
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createComapny(company);
        return new ResponseEntity<>("Company added successfully",HttpStatus.OK);
    }

}
