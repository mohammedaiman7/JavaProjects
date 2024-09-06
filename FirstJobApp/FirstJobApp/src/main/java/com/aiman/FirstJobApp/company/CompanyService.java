package com.aiman.FirstJobApp.company;


import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();
    boolean updateCompany(Company updatedCompany,Long id);
    void createComapny(Company company);
    boolean deleteCompany(Long id);

}
