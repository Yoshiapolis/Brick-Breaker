package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.Queue;

public final class BBEventQueue implements KeyListener, MouseListener, MouseMotionListener {
	private Queue<BBEvent> eventQueue;
	private boolean eventToProcess;
	private int maxQueueLength;

	public BBEventQueue() {
		super();

		this.setEventQueue(new LinkedList<BBEvent>());
		this.setMaxQueueLength(5);

		return;
	}

	public void flush() {

		this.getEventQueue().clear();
		this.setEventsToProcess(false);

		return;
	}

	public BBEvent getEvent() {
		BBEvent retVal;

		retVal = this.getEventQueue().poll();
		if (this.getEventQueue().isEmpty()) {
			this.setEventsToProcess(false);
		}

		return retVal;
	}

	private Queue<BBEvent> getEventQueue() {
		return eventQueue;
	}

	public int getMaxQueueLength() {
		return this.maxQueueLength;
	}

	public boolean isEventToProcess() {
		return this.eventToProcess;
	}

	@Override
	public void keyPressed(KeyEvent event) {

		if (this.getEventQueue().size() < this.getMaxQueueLength()) {
			this.getEventQueue().add(new BBEvent(event, BBEvent.EVENT_KEY_PRESS));
			this.setEventsToProcess(true);
		}

		return;
	}

	@Override
	public void keyReleased(KeyEvent event) {

		if (this.getEventQueue().size() < this.getMaxQueueLength()) {
			this.getEventQueue().add(new BBEvent(event, BBEvent.EVENT_KEY_RELEASE));
			this.setEventsToProcess(true);
		}

		return;
	}

	@Override
	public void keyTyped(KeyEvent event) {
		return;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		return;
	}

	@Override
	public void mouseDragged(MouseEvent event) {

		if (this.getEventQueue().size() < this.getMaxQueueLength()) {
			this.getEventQueue().add(new BBEvent(event, BBEvent.EVENT_MOUSE_DRAG));
			this.setEventsToProcess(true);
		}

		return;
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		return;
	}

	@Override
	public void mouseExited(MouseEvent event) {
		return;
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		
		if (this.getEventQueue().size() < this.getMaxQueueLength()) {
			this.getEventQueue().add(new BBEvent(event, BBEvent.EVENT_MOUSE_MOVE));
			this.setEventsToProcess(true);
		}
		return;
	}

	@Override
	public void mousePressed(MouseEvent event) {

		if (this.getEventQueue().size() < this.getMaxQueueLength()) {
			this.getEventQueue().add(new BBEvent(event, BBEvent.EVENT_MOUSE_BUTTON_PRESS));
			this.setEventsToProcess(true);
		}

		return;
	}

	@Override
	public void mouseReleased(MouseEvent event) {

		if (this.getEventQueue().size() < this.getMaxQueueLength()) {
			this.getEventQueue().add(new BBEvent(event, BBEvent.EVENT_MOUSE_BUTTON_RELEASE));
			this.setEventsToProcess(true);
		}

		return;
	}

	private void setEventQueue(Queue<BBEvent> queue) {

		this.eventQueue = queue;

		return;
	}

	private void setEventsToProcess(boolean process) {
		this.eventToProcess = process;
		return;
	}

	public void setMaxQueueLength(int length) {

		this.maxQueueLength = length;

		return;
	}

}
