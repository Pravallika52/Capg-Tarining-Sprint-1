package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.entity.Login;
import com.example.demo.exception.EmailNotFoundException;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.exception.PasswordNotSameException;
import com.example.demo.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
	ILoginRepository loginRepo;
	
	@Override
	public LoginResponseDto login(LoginDto loginDto) throws InvalidCredentialsException, PasswordNotSameException {
		Optional<Login> dbLoginOpt = loginRepo.findByLoginEmail(loginDto.getLoginEmail());
		if (dbLoginOpt.isPresent()) {
			// compare db password with user provided password
			// if password matching return credentials else throw exception
			Login login = dbLoginOpt.get();
			if (login.getLoginPassword().equals(loginDto.getLoginPassword())) {
				if(login.getRole().equals(loginDto.getRole())) {
				// if credentials matches, set loggedIn flag as true and save
				login.setLoggedIn(true);
				loginRepo.save(login);
				LoginResponseDto resDto = new LoginResponseDto();
				resDto.setEmail(login.getLoginEmail());
				resDto.setLoggedIn(login.isLoggedIn());
				resDto.setRole(login.getRole());
				return resDto;
				}
				else
				{
					throw new InvalidCredentialsException("The given mail does not belong to the Role given ");
				}
			}
			else {
				throw new PasswordNotSameException("Invalid credentials!");
			}
		}
			else {
				// throw exception if given email not present in the db.
				throw new InvalidCredentialsException("User not found with email: "+loginDto.getLoginEmail());
				
			}
		}
	
		@Override
		public LoginResponseDto logout(String email) throws EmailNotFoundException {
			Optional<Login> dbLoginOpt = loginRepo.findByLoginEmail(email);
			if(dbLoginOpt.isPresent()) {
				// update isLoggedIn flag as false and save
				Login login = dbLoginOpt.get();
				// Update flag to false and save
				login.setLoggedIn(false);
				loginRepo.save(login);
				// Convert Login obj to LoginRespDto
				LoginResponseDto resDto = new LoginResponseDto();
				resDto.setEmail(email);
				resDto.setLoggedIn(false);
				// return LoginRespDto obj
				return resDto;
			}
			else {
				throw new EmailNotFoundException("User not found with email: "+email);
			}
		}

		@Override
		public Login getById(int id) {
			// TODO Auto-generated method stub
			Optional<Login> log=loginRepo.findById(id);
			return log.get();
		}

		@Override
		public Login updateLogin(String email, Login login) {
			// TODO Auto-generated method stub
			Optional<Login> log=loginRepo.findByLoginEmail(email);
			Login newLogin=new Login();
			newLogin.setId(log.get().getId());
			newLogin.setLoginEmail(log.get().getLoginEmail());
			newLogin.setLoginPassword(login.getLoginPassword());
			newLogin.setRole(log.get().getRole());
			loginRepo.save(newLogin);
			return newLogin;
		}
		
		@Override
		public Login findByLoginEmail(String email) {
			Optional<Login> log=loginRepo.findByLoginEmail(email);
			
			return log.get();
		}

	}