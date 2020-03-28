package org.polariscode.SecuritySystem.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.model.SiteManage.SitePostWeek;
import org.polariscode.SecuritySystem.mapper.SiteManage.SiteManageMapper;
import org.polariscode.SecuritySystem.model.SiteManage.Schedule;
import org.polariscode.SecuritySystem.model.SiteManage.ScheduleOne;
import org.polariscode.SecuritySystem.model.Base.SitePersonnel;
import org.polariscode.SecuritySystem.mapper.SiteManage.SitePersonnelMapper;
import org.springframework.transaction.annotation.Transactional;
import org.polariscode.SecuritySystem.config.WebConfig;

@RestController
public class SiteManageController{

	@Autowired
	private SiteManageMapper m_SiteManageMapper;

	@Autowired
	private SitePersonnelMapper m_SitePersonnelMapper;

	@RequestMapping(value = "/SiteManage/getScheduleByWeek", method = RequestMethod.POST)
	public Result getScheduleByWeek(int siteid, java.util.Date date) {
		Result result = new Result();
		java.util.List<SitePostWeek> list = new java.util.ArrayList<SitePostWeek>();
		try{
			list = m_SiteManageMapper.getSitePostByWeek(date, siteid, date.getDay()==0?6:date.getDay()-1);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		java.util.List<Schedule> scheles = new java.util.ArrayList<Schedule>();
		int index = 0;
		int number = 0;
		while(index < list.size()){
			number = 0;
			while(number < list.get(index).getPosNumber()){
				Schedule s = new Schedule();
				scheles.add(s);
				if(number == 0){
					s.setPost(list.get(index).getPost());
					s.setSchedule(list.get(index).getSchedule());
					s.setBeginTime(list.get(index).getBeginTime());
					s.setEndTime(list.get(index).getEndTime());
				}
				s.setD1Date(list.get(index).getD1());
				if(number < list.get(index).getN1()){
					s.setD1SpiId(list.get(index).getSPI1());
				}
				s.setD2Date(list.get(index).getD2());
				if(number < list.get(index).getN2()){
					s.setD2SpiId(list.get(index).getSPI2());
				}
				s.setD3Date(list.get(index).getD3());
				if(number < list.get(index).getN3()){
					s.setD3SpiId(list.get(index).getSPI3());
				}
				s.setD4Date(list.get(index).getD4());
				if(number < list.get(index).getN4()){
					s.setD4SpiId(list.get(index).getSPI4());
				}
				s.setD5Date(list.get(index).getD5());
				if(number < list.get(index).getN5()){
					s.setD5SpiId(list.get(index).getSPI5());
				}
				s.setD6Date(list.get(index).getD6());
				if(number < list.get(index).getN6()){
					s.setD6SpiId(list.get(index).getSPI6());
				}
				s.setD7Date(list.get(index).getD7());
				if(number < list.get(index).getN7()){
					s.setD7SpiId(list.get(index).getSPI7());
				}
				number = number+1;
			}
			index = index+1;
		}
		index = 0;
		java.util.List<ScheduleOne> sList = new java.util.ArrayList<ScheduleOne>();
		while(index < 7){
			try{
				sList = m_SiteManageMapper.getScheduleByDay(siteid, date, (date.getDay()==0?6:date.getDay()-1) - index);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

			number = 0;
			while(number < sList.size()){
				int j = 0;
				while( j < scheles.size() ) {
					if ( index ==0 ) {
						if( scheles.get(j).getD1SpiId() == sList.get(number).getSpiId()  && scheles.get(j).getD1PID()==0 ){
							scheles.get(j).setD1SID( sList.get(number).getID() );
							scheles.get(j).setD1PID( sList.get(number).getPID() );
							scheles.get(j).setD1Status( sList.get(number).getStatus() );
							break;
						}
					}
					if ( index == 1 ) {
						if( scheles.get(j).getD2SpiId() == sList.get(number).getSpiId()  && scheles.get(j).getD2PID()==0 ){
							scheles.get(j).setD2SID( sList.get(number).getID() );
							scheles.get(j).setD2PID( sList.get(number).getPID() );
							scheles.get(j).setD2Status( sList.get(number).getStatus() );
							break;
						}
					}
					if ( index == 2 ) {
						if( scheles.get(j).getD3SpiId() == sList.get(number).getSpiId()  && scheles.get(j).getD3PID()==0 ){
							scheles.get(j).setD3SID( sList.get(number).getID() );
							scheles.get(j).setD3PID( sList.get(number).getPID() );
							scheles.get(j).setD3Status( sList.get(number).getStatus() );
							break;
						}
					}
					if ( index == 3 ) {
						if( scheles.get(j).getD4SpiId() == sList.get(number).getSpiId()  && scheles.get(j).getD4PID()==0 ){
							scheles.get(j).setD4SID( sList.get(number).getID() );
							scheles.get(j).setD4PID( sList.get(number).getPID() );
							scheles.get(j).setD4Status( sList.get(number).getStatus() );
							break;
						}
					}
					if ( index == 4 ) {
						if( scheles.get(j).getD5SpiId() == sList.get(number).getSpiId()  && scheles.get(j).getD5PID()==0 ){
							scheles.get(j).setD5SID( sList.get(number).getID() );
							scheles.get(j).setD5PID( sList.get(number).getPID() );
							scheles.get(j).setD5Status( sList.get(number).getStatus() );
							break;
						}
					}
					if ( index == 5 ) {
						if( scheles.get(j).getD6SpiId() == sList.get(number).getSpiId()  && scheles.get(j).getD6PID()==0 ){
							scheles.get(j).setD6SID( sList.get(number).getID() );
							scheles.get(j).setD6PID( sList.get(number).getPID() );
							scheles.get(j).setD6Status( sList.get(number).getStatus() );
							break;
						}
					}
					if ( index == 6 ) {
						if( scheles.get(j).getD7SpiId() == sList.get(number).getSpiId()  && scheles.get(j).getD7PID()==0 ){
							scheles.get(j).setD7SID( sList.get(number).getID() );
							scheles.get(j).setD7PID( sList.get(number).getPID() );
							scheles.get(j).setD7Status( sList.get(number).getStatus() );
							break;
						}
					}
					j = j+1;
				}
				number = number+1;
			}
			index = index + 1;
		}
		result.setData(scheles);
		return result;
	}

	//结事SitePersonnel
	@RequestMapping(value = "/SiteManage/outSitePersonnel", method = RequestMethod.POST)
	@Transactional
	public Result outSitePersonnel(int id, java.util.Date endDate) {
		Result result = new Result();
		SitePersonnel sp = new SitePersonnel();
		try{
			sp = m_SitePersonnelMapper.getSitePersonnelById(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		if(sp != null){
			sp.setEndDate(endDate);
			try{
				m_SitePersonnelMapper.updateSitePersonnel(sp);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		return result;
	}

	@RequestMapping(value = "/SiteManage/updateLeader", method = RequestMethod.POST)
	public Result updateLeader(int siteid, int pid) {
		Result result = new Result();
		try{
			m_SiteManageMapper.updateLeader(pid, siteid);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/SiteManage/updateSchedule", method = RequestMethod.POST)
	@Transactional
	public Result updateSchedule(int spiid, java.util.Date date, int sid, int pid) {
		Result result = new Result();
		String user = "";
		user = WebConfig.getUser();
		if(sid == 0){
			try{
				m_SiteManageMapper.insertSchedule(spiid, date, pid, user);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			try{
				m_SiteManageMapper.updateSchedule(sid, pid, user);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		return result;
	}

	@RequestMapping(value = "/SiteManage/updateScheduleStatus", method = RequestMethod.POST)
	@Transactional
	public Result updateScheduleStatus(int sid, int status) {
		Result result = new Result();
		String user = "";
		user = WebConfig.getUser();
		try{
			m_SiteManageMapper.updateScheduleStatus(sid, status, user);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		return result;
	}

	//员工调动
	@RequestMapping(value = "/SiteManage/updateSitePersonnel", method = RequestMethod.POST)
	@Transactional
	public Result updateSitePersonnel(int siteid, int pid, String job, String level, boolean ismain, java.util.Date beginDate) {
		Result result = new Result();
		//判断是否主岗，如果是主岗，则要将之前的主岗调出 
		if(ismain){
			SitePersonnel oldsp = new SitePersonnel();
			try{
				oldsp = m_SitePersonnelMapper.getMainSitePersonnel(pid);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			//如果有主岗记录
			if(oldsp != null){
				//将本次的调入日期赋值给原主岗的结束日期
				oldsp.setEndDate(beginDate);
				try{
					m_SitePersonnelMapper.updateSitePersonnel(oldsp);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
			}
		}
		SitePersonnel sp = new SitePersonnel();
		String user = "";
		user = WebConfig.getUser();
		sp.setSiteId(siteid);
		sp.setPID(pid);
		sp.setBeginDate(beginDate);
		sp.setIsMain(ismain);
		sp.setJob(job);
		sp.setLevel(level);
		try{
			m_SitePersonnelMapper.insertSitePersonnel(sp, user);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		return result;
	}

}
