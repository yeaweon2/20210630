package co.friend.access;

import co.friend.model.Friend;

// FriendAccess(인터페이스) 구현객체
// Database 저장.
public class FriendDB implements FriendAccess {

	@Override
	public void insert(Friend friend) {
		
	}

	@Override
	public void update(Friend friend) {
		
	}

	@Override
	public void delete(String name) {
		
	}

	@Override
	public Friend[] selectAll() {
		return null;
	}

	@Override
	public Friend selectOne(String name) {
		return null;
	}

	@Override
	public Friend findTel(String tel) {
		return null;
	}

}
