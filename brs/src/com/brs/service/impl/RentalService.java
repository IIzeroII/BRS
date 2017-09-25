package com.brs.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.brs.dao.BicycleDaoI;
import com.brs.dao.RentalDaoI;
import com.brs.dao.UsersDaoI;
import com.brs.model.Bicycle;
import com.brs.model.Rental;
import com.brs.model.Users;
import com.brs.pagemodel.PageRental;
import com.brs.service.RentalServiceI;
import com.brs.utils.GUtils;

public class RentalService implements RentalServiceI{
	//声明rentalDao
	private RentalDaoI rentalDao;

	public void setRentalDao(RentalDaoI rentalDao) {
		this.rentalDao = rentalDao;
	}
	//声明bicycleDao
	private BicycleDaoI bicycleDao;
	
	public void setBicycleDao(BicycleDaoI bicycleDao) {
		this.bicycleDao = bicycleDao;
	}
	//声明usersDao
	private UsersDaoI usersDao;

	public void setUsersDao(UsersDaoI usersDao) {
		this.usersDao = usersDao;
	}
	
	/**
	 * 查询所有记录
	 */
	@Override
	public List<PageRental> list() throws Exception {
		String hql = "from Rental where status = 1 order by id asc";
		Map<String, Object> parameters = null;
		//获取列表
		List<Rental> rs = rentalDao.queryByHql(hql,parameters, 0, 0);
		
		/**
		 * 设置页面显示需要属性
		 */
		//copy集合
		List<PageRental> listPage = GUtils.copyProList(PageRental.class,rs);
		//设置页面交互集合中需要属性
		for (int i = 0; i < rs.size(); i++) {
			//获取当前Rental,get(i)需要集合不为null
			Rental r = rs.get(i);
			//获取当前PageRental
			PageRental pr = listPage.get(i);
			//获取自行车对象
			Bicycle b = bicycleDao.get(Bicycle.class, r.getBicycle().getBicId());
			//获取用户对象
			Users u = usersDao.get(Users.class, r.getUsers().getUserId());
			//获取自行车种类
			pr.setType(b.getType());
			//获取自行车图片
			pr.setBicycleImgId(b.getImgs().getImgId());
			//获取用户姓名
			pr.setUserName(u.getName());
			//获取用户图片
			pr.setUserImgId(u.getImgs().getImgId());
			//获取金额
			Integer hours = getHours(r.getStartDate(),r.getEndDate());
			int money = hours*Integer.valueOf(b.getPrice())*Integer.valueOf(r.getNumber());
			pr.setMoney(money);
		}
		
		return listPage;
	}
	
	/**
	 * 计算两个时间戳的小时差
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	private Integer getHours(Timestamp startTime,Timestamp endTime){
		Integer hours = 0;
		
		long l=endTime.getTime()-startTime.getTime();
		Double doubleHours =l/(60*60*1000d); 
		//存在余数折算为一小时
		if(doubleHours % 1d == 0){
			hours = doubleHours.intValue();
		}else{
			hours = doubleHours.intValue()+1;
		}
		return hours;
	}
	
	/**
	 * 新增一条订单记录
	 */
	@Override
	public void add(PageRental pageModel) throws Exception {
		//获取Rental对象
		Rental rental = rentalDao.get(Rental.class, pageModel.getId());
		//查询数据库是否存在该记录
		if(null != rental){
			//判断rental的状态
			if(rental.getStatus() == 1){
				throw new Exception("该订单已存在！");
			}else {
				//删除无效订单
				rentalDao.delete(rental);
			}
		}
		//初始化Rental(除了插入可以new一个新对象,其他操作要获取数据库对象)
		rental = new Rental();
		
		/**
		 * 设置数据库需求属性
		 */
		//判断该用户是否存在
		Users user =  usersDao.get(Users.class, pageModel.getUserId());
		if(null == user){
			throw new Exception("该用户不存在！请输入正确的租赁人ID！");
		}
		//判断该种类是否存在
		String hql = "from Bicycle where type = :type";
		Map<String, Object> parameters = GUtils.getMap(new String[]{"type"}, new Object[]{pageModel.getType()});
		Bicycle bicycle = bicycleDao.getByHql(hql,parameters);
		if(null == bicycle){
			throw new Exception("该种类不存在！请输入正确的种类名！");
		}
		//copy公共属性
		BeanUtils.copyProperties(pageModel, rental);
		//设置订单状态
		rental.setStatus(1);
		//设置自行车状态,并更新数据库
		bicycle.setStatus(1);
		bicycleDao.saveOrUpdate(bicycle);
		//设置用户状态,并更新数据库
		user.setStatus(1);
		usersDao.saveOrUpdate(user);
		//设置租赁人ID
		rental.setUsers(user);
		//设置自行车种类ID
		rental.setBicycle(bicycle);
		
		//保存到数据库
		rentalDao.save(rental);
	}
	
	/**
	 * 查询一条订单记录
	 */
	@Override
	public void details(PageRental pageModel) throws Exception {
		//从数据库中获取rental
		Rental rental = rentalDao.get(Rental.class, pageModel.getId());
		
		/**
		 * 设置页面交互对象需要属性
		 */
		
		//copy对象公共属性
		BeanUtils.copyProperties(rental, pageModel);
		
		//获取自行车对象
		Bicycle bicycle = bicycleDao.get(Bicycle.class, rental.getBicycle().getBicId());
		//获取用户对象
		Users user = usersDao.get(Users.class, rental.getUsers().getUserId());
		
		//获取自行车种类
		pageModel.setType(bicycle.getType());
		//获取自行车图片
		pageModel.setBicycleImgId(bicycle.getImgs().getImgId());
		//获取自行车单价
		pageModel.setPrice(bicycle.getPrice());
		//获取金额
		Integer hours = getHours(rental.getStartDate(),rental.getEndDate());
		int money = hours*Integer.valueOf(bicycle.getPrice())*Integer.valueOf(rental.getNumber());
		pageModel.setMoney(money);
		//获取租赁人ID
		pageModel.setUserId(user.getUserId());
		//获取用户姓名
		pageModel.setUserName(user.getName());
		//获取用户图片
		pageModel.setUserImgId(user.getImgs().getImgId());
		
	}
	
	/**
	 * 修改一条订单记录
	 */
	@Override
	public void edit(PageRental pageModel) throws Exception {
		//初始化Rental对象(除了插入可以new一个新对象,其他操作要获取数据库对象)
		Rental rental = rentalDao.get(Rental.class, pageModel.getId());
		//获取原用户对象
		Users user_old = usersDao.get(Users.class, rental.getUsers().getUserId());
		//获取原自行车对象
		Bicycle bicycle_old = bicycleDao.get(Bicycle.class, rental.getBicycle().getBicId());
		
		/**
		 * 判断用户和自行车对象是否被其他订单使用
		 */
		//查询除自己外使用了该用户对象的订单
		String hql1 = "from Rental r where r.status = 1 and r.users.userId = :userId and r.id != :id";
		Map<String, Object> parameters1 = GUtils.getMap(new String[]{"userId","id"}, new Object[]{user_old.getUserId(),rental.getId()});
		List<Rental> rs1 = rentalDao.queryByHql(hql1,parameters1, 0, 0);
		if(rs1.size()==0){	//没有订单使用该用户对象 注意：此时list仍占用内存,所以判断它的size
			//设置原用户状态,并更新数据库  
			user_old.setStatus(-1);
			usersDao.saveOrUpdate(user_old);
		}
		//查询除自己外使用了该自行车对象的订单
		String hql2 = "from Rental r where r.status = 1 and r.bicycle.bicId = :bicId and r.id != :id";
		Map<String, Object> parameters2 = GUtils.getMap(new String[]{"bicId","id"}, new Object[]{bicycle_old.getBicId(),rental.getId()});
		List<Rental> rs2 = rentalDao.queryByHql(hql2,parameters2, 0, 0);
		if(rs2.size()==0){	//没有订单使用该自行车对象 注意：此时list仍占用内存,所以判断它的size
			//设置原自行车状态,并更新数据库
			bicycle_old.setStatus(-1);
			bicycleDao.saveOrUpdate(bicycle_old);
		}
		
		/**
		 * 设置数据库需求属性
		 */
		//判断新添加用户是否存在
		Users user =  usersDao.get(Users.class, pageModel.getUserId());
		if(null == user){
			throw new Exception("该用户不存在！请输入正确的租赁人ID！");
		}
		//判断新添加种类是否存在
		String hql = "from Bicycle where type = :type";
		Map<String, Object> parameters = GUtils.getMap(new String[]{"type"}, new Object[]{pageModel.getType()});
		Bicycle bicycle = bicycleDao.getByHql(hql,parameters);
		if(null == bicycle){
			throw new Exception("该种类不存在！请输入正确的种类名！");
		}
		//copy公共属性
		BeanUtils.copyProperties(pageModel, rental);
		//设置订单状态
		rental.setStatus(1);
		//设置新添加用户状态,并更新数据库
		user.setStatus(1);
		usersDao.saveOrUpdate(user);
		//设置新添加种类状态,并更新数据库
		bicycle.setStatus(1);
		bicycleDao.saveOrUpdate(bicycle);
		//设置租赁人ID
		rental.setUsers(user);
		//设置自行车种类ID
		rental.setBicycle(bicycle);
		
		//更新数据库记录
		rentalDao.saveOrUpdate(rental);
	}
	
	/**
	 * 删除一条订单记录
	 */
	@Override
	public void del(PageRental pageModel) throws Exception {
		//从数据库中获取rental记录
		Rental rental = rentalDao.get(Rental.class, pageModel.getId());
		//获取用户对象
		Users user = usersDao.get(Users.class, rental.getUsers().getUserId());
		//获取自行车对象
		Bicycle bicycle = bicycleDao.get(Bicycle.class, rental.getBicycle().getBicId());
		System.out.println(bicycle);
		
		//将rental状态设为0(删除状态)
		rental.setStatus(0);
		rentalDao.saveOrUpdate(rental);
		
		/**
		 * 判断用户和自行车对象是否被其他订单使用
		 */
		//查询使用了该用户对象的订单
		String hql1 = "from Rental r where r.status = 1 and r.users.userId = :userId";
		Map<String, Object> parameters1 = GUtils.getMap(new String[]{"userId"}, new Object[]{user.getUserId()});
		List<Rental> rs1 = rentalDao.queryByHql(hql1,parameters1, 0, 0);
		if(rs1.size()==0){	//没有订单使用该用户对象 注意：此时list仍占用内存,所以判断它的size
			//设置用户状态,并保存到数据库  
			user.setStatus(-1);
			usersDao.saveOrUpdate(user);
		}
		//查询使用了该自行车对象的订单
		String hql2 = "from Rental  r where r.status = 1 and r.bicycle.bicId = :bicId";
		Map<String, Object> parameters2 = GUtils.getMap(new String[]{"bicId"}, new Object[]{bicycle.getBicId()});
		List<Rental> rs2 = rentalDao.queryByHql(hql2,parameters2, 0, 0);
		if(rs2.size()==0){	//没有订单使用该自行车对象 注意：此时list仍占用内存,所以判断它的size
			//设置自行车状态,并保存到数据库
			bicycle.setStatus(-1);
			bicycleDao.saveOrUpdate(bicycle);
		}
		
		
	}
	
	
	/**
	 * 搜索订单信息
	 */
	@Override
	public List<PageRental> search(String searchCon) throws Exception {
		  
		String hql = "select new Rental(r.id,r.users,r.bicycle,r.startDate,r.endDate,r.number,r.status) from Rental r, Bicycle b, Users u where (r.bicycle.bicId = b.bicId and r.users.userId = u.userId) and (r.status = 1) and ((r.id like :searchCon or r.startDate like :searchCon or r.endDate like :searchCon or r.number like :searchCon) or (b.type like :searchCon or b.price like :searchCon) or (u.userId like :searchCon or u.name like :searchCon or u.sex like :searchCon or u.tel like :searchCon or u.email like :searchCon)) order by r.id asc";
		Map<String, Object> parameters = GUtils.getMap(new String[]{"searchCon"}, new Object[]{"%"+searchCon+"%"});
		//获取列表id
		List<Rental> rs = rentalDao.queryByHql(hql,parameters, 0, 0);
		
		/**
		 * 设置页面显示需要属性
		 */
		//初始化一个PageRental集合
		List<PageRental> listPage = new ArrayList<PageRental>(); 
		//设置页面交互集合中需要属性
		for (int i = 0; i < rs.size(); i++) {
			//获取当前Rental
			Rental r = rentalDao.get(Rental.class, rs.get(i).getId());
			//初始化一个PageRental
			PageRental pr = new PageRental();
			//copy公共属性
			BeanUtils.copyProperties(r, pr);
			//获取自行车对象
			Bicycle b = bicycleDao.get(Bicycle.class, r.getBicycle().getBicId());
			//获取用户对象
			Users u = usersDao.get(Users.class, r.getUsers().getUserId());
			//获取自行车种类
			pr.setType(b.getType());
			//获取自行车图片
			pr.setBicycleImgId(b.getImgs().getImgId());
			//获取用户姓名
			pr.setUserName(u.getName());
			//获取用户图片
			pr.setUserImgId(u.getImgs().getImgId());
			//获取金额
			Integer hours = getHours(r.getStartDate(),r.getEndDate());
			int money = hours*Integer.valueOf(b.getPrice())*Integer.valueOf(r.getNumber());
			pr.setMoney(money);
			
			//添加到listPage集合中
			listPage.add(pr);
		}
		
		return listPage;
	}
	
	
}
