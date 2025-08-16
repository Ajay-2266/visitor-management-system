package com.visitor.service;

import com.visitor.entity.OTPRecord;
import com.visitor.repository.OTPRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OTPService {
    private final OTPRecordRepository repo;

    public OTPService(OTPRecordRepository repo) {
        this.repo = repo;
    }

    public List<OTPRecord> getAll() {
        return repo.findAll();
    }
    public OTPRecord create(OTPRecord otp) {
        
        return repo.save(otp);
    }

    public OTPRecord createOtp(String phone) {
        String otpCode = String.format("%06d", new Random().nextInt(999999));
        OTPRecord record = new OTPRecord();
        record.setPhone(phone);
        record.setOtp(otpCode);
        record.setCreatedAt(LocalDateTime.now());
        repo.save(record);
        System.out.println("Sending OTP to " + phone + ": " + otpCode);
        return record;
    }

    public boolean verifyOtp(String phone, String otpCode) {
        Optional<OTPRecord> latestOtp = repo.findTopByPhoneOrderByCreatedAtDesc(phone);
        if (latestOtp.isPresent()) {
            OTPRecord record = latestOtp.get();
            if (!record.isIsverified() && record.getOtp().equals(otpCode)) {
                record.setIsverified(true);
                repo.save(record);
                return true;
            }
        }
        return false;
    }
}
