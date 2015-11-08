import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
public class Semaphores{
	int state;
	final int capacity;
	Lock lock;
	Condition condition;
	public Semaphores(int c){
		capacity = c;
		state = 0;
		lock = new ReentrantLock();
		condition = lock.newCondition();
	}
	public void acquire() throws InterruptedException{
		lock.lock();
		try{
			while(state == capacity){
				condition.await();
			}
			state++;
		}finally{
			lock.unlock();
		}
	}
	public void release(){
		lock.lock();
		try{
			state--;
			condition.signalAll();
		}finally{
			lock.unlock();
		}
	}
}
