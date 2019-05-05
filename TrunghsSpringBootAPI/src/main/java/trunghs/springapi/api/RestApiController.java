package trunghs.springapi.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trunghs.springapi.model.Work;
import trunghs.springapi.service.WorkService;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	WorkService workService;

	//Find all work
	@RequestMapping(value = "/work/", method = RequestMethod.GET)
	public ResponseEntity<List<Work>> listAllWork() {
		List<Work> listContact = workService.findAll();
		if (listContact.isEmpty()) {
			return new ResponseEntity<List<Work>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Work>>(listContact, HttpStatus.OK);
	}
	
	//Find work by id
	@RequestMapping(value = "/work/{work_id}", method = RequestMethod.GET)
	public Work findWork(@PathVariable("work_id") long id) {
		Work work= workService.getOne(id);
		if(work == null) {
			ResponseEntity.notFound().build();
		}
		return work;
	}
	
	//Add new record
	@RequestMapping(value = "/work/", method = RequestMethod.POST)
	public Work saveWork(@Valid @RequestBody Work work) {
		return workService.save(work);
	}
	
	//Update work
	@RequestMapping(value = "/work/", method = RequestMethod.PUT)
	public ResponseEntity<Work> updateWork(@PathVariable(value = "work_id") Long workId, 
	                                       @Valid @RequestBody Work workForm) {
		Work work = workService.getOne(workId);
	    if(work == null) {
	        return ResponseEntity.notFound().build();
	    }
	    work.setWork_nm(workForm.getWork_nm());
	    work.setWork_start_dt(workForm.getWork_start_dt());
	    work.setWork_end_dt(workForm.getWork_end_dt());
	    work.setStatus(workForm.getStatus());
	    
	    Work updateWork = workService.save(work);
	    return ResponseEntity.ok(updateWork);
	}
	
	@RequestMapping(value = "/work/{work_id}", method = RequestMethod.DELETE)
	public ResponseEntity<Work> deleteWork(@PathVariable(value = "work_id") Long workId) {
		Work work = workService.getOne(workId);
	    if(work == null) {
	        return ResponseEntity.notFound().build();
	    }

	    workService.delete(work);
	    return ResponseEntity.ok().build();
	}
}
