package com.admin;

import com.admin.Repository.ActivityRepository;
import com.admin.Repository.AdminRepository;
import com.admin.Repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}



	@Bean
	public HttpServletResponse servletResponse(){ return new HttpServletResponse() {
		@Override
		public void addCookie(Cookie cookie) {

		}

		@Override
		public boolean containsHeader(String name) {
			return false;
		}

		@Override
		public String encodeURL(String url) {
			return null;
		}

		@Override
		public String encodeRedirectURL(String url) {
			return null;
		}

		@Override
		public String encodeUrl(String url) {
			return null;
		}

		@Override
		public String encodeRedirectUrl(String url) {
			return null;
		}

		@Override
		public void sendError(int sc, String msg) throws IOException {

		}

		@Override
		public void sendError(int sc) throws IOException {

		}

		@Override
		public void sendRedirect(String location) throws IOException {

		}

		@Override
		public void setDateHeader(String name, long date) {

		}

		@Override
		public void addDateHeader(String name, long date) {

		}

		@Override
		public void setHeader(String name, String value) {

		}

		@Override
		public void addHeader(String name, String value) {

		}

		@Override
		public void setIntHeader(String name, int value) {

		}

		@Override
		public void addIntHeader(String name, int value) {

		}

		@Override
		public void setStatus(int sc) {

		}

		@Override
		public void setStatus(int sc, String sm) {

		}

		@Override
		public int getStatus() {
			return 0;
		}

		@Override
		public String getHeader(String name) {
			return null;
		}

		@Override
		public Collection<String> getHeaders(String name) {
			return null;
		}

		@Override
		public Collection<String> getHeaderNames() {
			return null;
		}

		@Override
		public String getCharacterEncoding() {
			return null;
		}

		@Override
		public String getContentType() {
			return null;
		}

		@Override
		public ServletOutputStream getOutputStream() throws IOException {
			return null;
		}

		@Override
		public PrintWriter getWriter() throws IOException {
			return null;
		}

		@Override
		public void setCharacterEncoding(String charset) {

		}

		@Override
		public void setContentLength(int len) {

		}

		@Override
		public void setContentLengthLong(long length) {

		}

		@Override
		public void setContentType(String type) {

		}

		@Override
		public void setBufferSize(int size) {

		}

		@Override
		public int getBufferSize() {
			return 0;
		}

		@Override
		public void flushBuffer() throws IOException {

		}

		@Override
		public void resetBuffer() {

		}

		@Override
		public boolean isCommitted() {
			return false;
		}

		@Override
		public void reset() {

		}

		@Override
		public void setLocale(Locale loc) {

		}

		@Override
		public Locale getLocale() {
			return null;
		}
	};}

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		ApplicationContext ctx =SpringApplication.run(DemoApplication.class, args);
		AgenceRepository agence=ctx.getBean(AgenceRepository.class);
		ActivityRepository activity=ctx.getBean(ActivityRepository.class);


	}


	@Override
	public void run(String... args) throws  Exception {

	//adminRepository.save(new Admin((long) 103,"Laftoumi","Fatima Ezzahra","EE456644","admin2@AFOIHebank.com",new BCryptPasswordEncoder().encode("admin")));


	//	adminRepository.save(new Admin((long)44,"hajar", bCryptPasswordEncoder.encode("hajar")));
	}
}


