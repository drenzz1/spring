package org.foo.repository;

import org.foo.enums.Role;
import org.foo.model.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails,Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<AccountDetails> findAllByCountryOrState(String country , String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value

    List<AccountDetails> findAllByAgeLessThanEqual(Integer  age);

    //Write a derived query to list all accounts with a specific role
    List<AccountDetails> findAllByRole(Role role);

    //Write a derived query to list all accounts between a range of ages
    List<AccountDetails>findAllByAgeBetween(Integer ageStart,Integer ageEnd);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<AccountDetails>findAllByAddressStartingWith(String containing);

    //Write a derived query to sort the list of accounts with age
    List<AccountDetails>findAllByOrderByAgeDesc();

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("Select a from AccountDetails  a")
    List<AccountDetails> listAllAccounts();

    //Write a JPQL query to list all admin accounts
    @Query("Select a from AccountDetails a where a.role = 'ADMIN' ")
    List<AccountDetails>listAllAdminAccounts();

    //Write a JPQL query to sort all accounts with age
    @Query("Select a from AccountDetails a order by a.age  ")
    List<AccountDetails>listAllSortedAccountsInAscForm();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(nativeQuery = true , value = " SELECT * from account_details where age < ?1")
    List<AccountDetails>listAllAccountsWhereAgeLowerThan(Integer age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(nativeQuery = true , value = " SELECT * from account_details where  name  ilike concat('%',?1,'%')" +
            "or address ilike concat('%',?1,'%')" +
            " or country ilike concat('%',?1,'%')" +
            "or state ilike concat('%',?1,'%')" +
            " or city ilike concat('%',?1,'%') ")
    List<AccountDetails>listAllAccountsWhereNameOrAddressOrCountryOrStateOrCityContain(String contain);
    //Write a native query to read all accounts with an age higher than a specific value
    @Query(nativeQuery = true , value = " SELECT * from account_details where age > ?1")
    List<AccountDetails>listAllAccountsWhereAgeHigherThan(Integer age);
    @Query(nativeQuery = true , value = " SELECT * from account_details where age < :age")
    List<AccountDetails>listAllAccountsWhereAgeLowerThan1(Integer age);
    @Query(nativeQuery = true , value = " SELECT * from account_details where age < :inputAge")
    List<AccountDetails>listAllAccountsWhereAgeLowerThan2(@Param("inputAge") Integer age);

}
