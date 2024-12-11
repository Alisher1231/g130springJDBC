package kz.bitlab.g130springjdbc.service;

import kz.bitlab.g130springjdbc.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final Connection connection;

    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM countries");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getLong("id"));
                country.setName(resultSet.getString("name"));
                country.setCode(resultSet.getString("code"));
                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }
}
