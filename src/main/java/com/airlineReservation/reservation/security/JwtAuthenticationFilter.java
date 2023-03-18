package com.airlineReservation.reservation.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.airlineReservation.reservation.services.UserDetailServiceImp;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	UserDetailServiceImp userDetailServiceImp;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwtToken = extractJwtFromRequest(request);
			if(org.springframework.util.StringUtils.hasText(jwtToken) &&  jwtTokenProvider.validateToken(jwtToken)) {
				int id = jwtTokenProvider.getUserIdFromJwt(jwtToken);
				UserDetails user  = userDetailServiceImp.loadUserById(id);
				if(user != null) {
					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
					auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(auth);
				}
			}
		} catch(Exception e) {
			return;
		}
		filterChain.doFilter(request, response);
		
	}

	private String extractJwtFromRequest(HttpServletRequest request) {
		String bearer = request.getHeader("Authorization");
		if(org.springframework.util.StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")) {
			return bearer.substring("Bearer".length()+1);
		}
		return null;
	}

}
