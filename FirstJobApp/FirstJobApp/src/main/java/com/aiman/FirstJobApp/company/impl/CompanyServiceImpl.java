package com.aiman.FirstJobApp.company.impl;

import com.aiman.FirstJobApp.company.Company;
import com.aiman.FirstJobApp.company.CompanyRepository;
import com.aiman.FirstJobApp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }



    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company updatedCompany,Long id) {
        Optional<Company> companyOptional= companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company=companyOptional.get();
            company.setDescription(updatedCompany.getDescription());
            company.setId(updatedCompany.getId());
            company.setJobs(updatedCompany.getJobs());
            company.setName(updatedCompany.getName());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public void createComapny(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompany(Long id) {

        return false;
    }
}
