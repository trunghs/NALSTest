package trunghs.springapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Work implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotBlank
	private String work_nm;
	private Date work_start_dt;
	private Date work_end_dt;
	private String status;
	private char del_f;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotBlank
	private long work_id;

	public Work() {
		work_id = 0;
	}

	public Work(String work_nm, Date work_start_dt, Date work_end_dt, String status, char del_f, long work_id) {
		this.work_nm = work_nm;
		this.work_start_dt = work_start_dt;
		this.work_end_dt = work_end_dt;
		this.status = status;
		this.del_f = del_f;
		this.work_id = work_id;
	}

	public String getWork_nm() {
		return work_nm;
	}

	public void setWork_nm(String work_nm) {
		this.work_nm = work_nm;
	}

	public Date getWork_start_dt() {
		return work_start_dt;
	}

	public void setWork_start_dt(Date work_start_dt) {
		this.work_start_dt = work_start_dt;
	}

	public Date getWork_end_dt() {
		return work_end_dt;
	}

	public void setWork_end_dt(Date work_end_dt) {
		this.work_end_dt = work_end_dt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public char getDel_f() {
		return del_f;
	}

	public void setDel_f(char del_f) {
		this.del_f = del_f;
	}

	public long getWork_id() {
		return work_id;
	}

	public void setWork_id(long work_id) {
		this.work_id = work_id;
	}

}
