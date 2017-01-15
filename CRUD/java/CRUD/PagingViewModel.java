package CRUD;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import java.sql.SQLException;
import java.util.List;

public class PagingViewModel {

	public User user = new User();
	public User getUser() {
		return user;
	}



	public PagingViewModel() throws SQLException {
	}


	InboxData userData = new InboxData();
	public InboxData getUserData() {
		return userData;
	}
	private Filter filter = new Filter();

	public List<User> currentFood = userData.getAllFoods();

	public Filter getFilter() {
		return filter;
	}

	public ListModel<User> getFoodModel() {
		return new ListModelList<User>(currentFood);
	}

	@Command
	@NotifyChange({"foodModel","userData"})
	public void revertMail() throws SQLException {

		userData.createUser(user);
		userData.revertDeletedMails();
		currentFood = userData.getAllFoods();
		currentFood = userData.getFilterFoods(filter);
	}

	@Command
	@NotifyChange({"foodModel","userData"})
	public void update() {
		userData.revertDeletedMails();
		changeFilter();

	}




	@Command
	@NotifyChange({"foodModel"})
	public void changeFilter() {

		currentFood = userData.getAllFoods();
		currentFood = userData.getFilterFoods(filter);

	}

	@Command
	@NotifyChange({"foodModel","mailData"})
	public void removeMail(@BindingParam("usertodelete") User myUser) throws SQLException {
		userData.removeUser(myUser);
		userData.revertDeletedMails();
		currentFood = userData.getAllFoods();
		currentFood = userData.getFilterFoods(filter);
	}
	@Command
	@NotifyChange({"foodModel","mailData"})
	public void removeAllUsers() throws SQLException {
		userData.removeAllUsers();
		userData.revertDeletedMails();
		currentFood = userData.getAllFoods();
		currentFood = userData.getFilterFoods(filter);
	}

	@Command
	@NotifyChange({"foodModel","mailData"})
	public void create10RandomUsers() throws SQLException {
		userData.create10RandomUsers();
		userData.revertDeletedMails();
		currentFood = userData.getAllFoods();
		currentFood = userData.getFilterFoods(filter);
	}

	@Command
	@NotifyChange({"foodModel","mailData"})
	public void updateUser(@BindingParam("usertoupdate") User myUser) throws SQLException {
		userData.updateUser(myUser);

	}
}
