package com.springrest.springrest.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.dto.OrderRequest;
import com.springrest.springrest.dto.OrderResponse;
//import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.entities.ImageData;
import com.springrest.springrest.helper.FileUploadHelper;
import com.springrest.springrest.services.CourseService;

@RestController  //sends data in j-son format
public class MyController {
	
	@Value("${app.name}")
	private String appName;
	
	@Autowired
	private CourseService courseService; //dependency injection
	
//	@Autowired
//	private CourseDao courseDao;
	
	@Autowired
	private  FileUploadHelper fileUploadHelper;
	
	@GetMapping("/home")
	public String home(){
		return  "Hello" + appName; 
	}
		
		//get all courses
		@GetMapping("/courses")
		public List<Courses> getCourses(){
			return this.courseService.getCourses();
		}
		
		
		//single course get
		@GetMapping("courses/{courseId}")         //@PathVariable to receive the id value entered by user
		public Optional<Courses> getCourse(@PathVariable Long courseId) {  
			return this.courseService.getCourse(courseId);
		}
		
		// add course
		@PostMapping("/courses")
		public Courses addCourse(@RequestBody Courses course) { //object will come from request body 
			return this.courseService.addCourse(course);
		}
		
		//update course 
		@PutMapping("/courses")
		public Courses updateCourse(@RequestBody Courses course) {
			return this.courseService.updateCourse(course);
		}
		
		@DeleteMapping("/courses/{courseId}")
		public Courses deleteCourse(@PathVariable Long courseId) {
			return this.courseService.deleteCourse(courseId);
		}
		
//		@GetMapping("/courses/{pageNo}/{pageSize}/{sortBy}")   
//		public List<Courses> getpaginated(
//                @RequestParam(defaultValue = "0") Integer pageNo,
//                @RequestParam(defaultValue = "1") Integer pageSize,
//                @RequestParam(defaultValue = "title") String sortBy){
//			return this.courseService.findPaginated(pageNo, pageSize,sortBy);
//		}
		
		@GetMapping("/courses/{pageNo}/{pageSize}/{sortBy}")   
		public List<Courses> getpaginated(
                @PathVariable Integer pageNo,
                @PathVariable Integer pageSize,
                @PathVariable String sortBy){
			return this.courseService.findPaginated(pageNo, pageSize,sortBy);
		}
		

		@RequestMapping(value="/sendfile",method=RequestMethod.POST,consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
		public ImageData uploadFile(@RequestParam(required = true,value = "photo")MultipartFile photo,
						@RequestParam(value="doc") String d)throws IOException
		{
			ImageData img=new ImageData();
			img.setPhoto(photo.getBytes());
			ObjectMapper o=new ObjectMapper();
			ImageData im=o.readValue(d, ImageData.class);
			img.setImageId(im.getImageId());
			img.setImageName(im.getImageName());
			ImageData id=courseService.setFile(img);
			return id;
		}
		
		@PostMapping("/placeOrder")
		public Courses placeOrder(@RequestBody OrderRequest request) {
//			System.out.println(request.getCourse().getId());
					return this.courseService.saveD(request);
		}
		
		
		@GetMapping("/findAllOrders")			
		public Iterable<Courses> findAllOrders(){
			return this.courseService.findAl();
		}
		
		@GetMapping("/getinfo")			
		public Iterable<OrderResponse> getJoinInformation(){
			return this.courseService.getJoinInformation();
		}
		@GetMapping("/getinfoleft")			
		public Iterable<OrderResponse> getJoinLeftInformation(){
			return this.courseService.getJoinLeftInformation();
		}
		
		@GetMapping("/getinforight")			
		public Iterable<OrderResponse> getJoinRightInformation(){
			return this.courseService.getJoinRightInformation();
		}
		
		@PostMapping("/upload-file")
		public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getSize());
			System.out.println(file.getContentType());
			System.out.println(file.getName());
//			return ResponseEntity.ok("Working");
//			
			

			try {
				
				//validation
				if(file.isEmpty())
				{
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
				}
				
				//
//				if(!file.getContentType().equals("images/jpg"))
//				{
//					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Jpeg  content type are allowed");
//				}
				
				//file uploaded code..
				boolean f=fileUploadHelper.uploadFile(file);
				if(f)
				{
//					return  ResponseEntity.ok("File is successfully uploaded");
					return  ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
				}
				
				}catch(Exception e){
					e.printStackTrace();
				}
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong !! please try again");
			


				
		}
		
		
	
		
		

}
