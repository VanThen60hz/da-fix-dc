package com.dtu.elibrary.service;

import com.dtu.elibrary.payload.LoginDto;
import com.dtu.elibrary.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
