package com.mongoDb.repository;

import com.mongoDb.entity.PinCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PincodeRepository extends MongoRepository<PinCode, String> {

    public List<PinCode> findByPincode(Double pincode) ;
}
