package com.mongoDb.Service.impl;

import com.mongoDb.Response.PincodeResponse;
import com.mongoDb.Service.PinCodeService;
import com.mongoDb.entity.PinCode;
import com.mongoDb.repository.PincodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PincodeServiceImpl implements PinCodeService {

    @Autowired
    PincodeRepository repository ;
    @Override
    public PincodeResponse getPincodeData(Double pincode) {

        List<PinCode> ent = repository.findByPincode(pincode) ;


        PincodeResponse resp = new PincodeResponse() ;

        resp.setCity(ent.get(1).getCity());
        resp.setCountry(ent.get(1).getCountry());
        resp.setState(ent.get(1).getState());

        return resp ;
    }

}
