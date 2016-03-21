import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	// Array of generic data
	private Item[] items;
	// Size of queue
	private int N;

	// Initialize RandomizedQueue object
	public RandomizedQueue() {
		items = (Item[]) new Object[2];
		N = 0;
	}

	// Test RandomizedQueue for empty by testing size for 0
	public boolean isEmpty() {
		return N == 0;
	}

	// Return size of the RandomizedQueue
	public int size() {
		return N;
	}

	// Resize the RandomizedQueue
	private void resize(int max) {
		assert max > N;

		// New array of the size designated
		Item[] temp = (Item[]) new Object[max];

		// Copy all items from old array to new array
		for (int i = 0; i < N; ++i) {
			if (items[i] != null) {
				temp[i] = items[i];
			}
		}

		// Copies new array into old array
		items = temp;
	}

	public void enqueue(Item item) {
		if (item == null || item.equals(null)) {
			throw new NullPointerException("Cannot add NULL");
		}

		// Test RandomizedQueue for being at capacity,
		//  if so, resize to twice the previous capacity
		if (items.length == N) {
			resize(items.length * 2);
		}

		// Add new item to the queue
		items[N] = item;
		// Increment the size
		++N;
	}

	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}

		// Generate random integer index value from 0 to N
		int randomIndex = StdRandom.uniform(N);

		// Item to dequeue is at the index randomly generated
		Item item = items[randomIndex];

		if (N - 1 != randomIndex) {
			// Swap end item into slot of item to return
			items[randomIndex] = items[N - 1];
		}

		// NULL end slot
		items[N - 1] = null;

		// Test to see if RandomizedQueue needs resizing
		if (N == (items.length / 4)) {
			resize(items.length / 2);
		}

		// Decrement size
		--N;

		// Return item from the index randomly generated
		return item;
	}

	public Item sample() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}

		// Generate random integer index value from 0 to N
		int randomIndex = StdRandom.uniform(N);

		// Return item from the index randomly generated
		return items[randomIndex];
	}

	@Override
	public Iterator<Item> iterator() {
		return new RandomizedQueueIterator();
	}

	private class RandomizedQueueIterator implements Iterator<Item> {
		// Current index with this specific iterator
		int curr = 0;
		// Array of indices
		int[] randIndices;

		// Initialize RandomizedQueueIterator object
		public RandomizedQueueIterator() {
			// Array of random indices size of RandomizedQueue
			randIndices = new int[N];

			// Assign integers to array
			for (int i = 0; i < N; ++i) {
				randIndices[i] = i;
			}

			// Shuffle array of indices
			StdRandom.shuffle(randIndices);
		}

		// Test if the iterator can move to next slot
		@Override
		public boolean hasNext() {
			return (curr < N);
		}

		// Move iterator to next slot
		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			return items[randIndices[curr++]];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	public static void main(String[] args) {
		// Create new RandomizedQueue object
		RandomizedQueue<Integer> nums = new RandomizedQueue<Integer>();

		// Size of RandomizedQueue
		int N = 5;

		// Add integers to RandomizedQueue
		StdOut.println("Adding numbers 0 - " + (N - 1) + " to the queue...");
		for (int i = 0; i < N; ++i) {
			nums.enqueue(i);
		}

		StdOut.println();

		// Test iterator functionality
		StdOut.println("Iterating through 1 outer queue and " + N
				+ " inner queues...");
		int index = 0;
		// Outer foreach queue
		for (int num : nums) {
			StdOut.println("Outer queue slot " + index + ": " + num);
			
			StdOut.print("Inner queue: [\t");

			// Inner foreach queue
			for (int n : nums) {
				StdOut.print(n + "\t");
			}
			
			StdOut.println("]");

			++index;
		}

		StdOut.println();

		// Test sample functionality
		StdOut.println(N + " random samples from the queue...");
		for (int i = 0; i < N; ++i) {
			StdOut.println("Sample " + (i + 1) + ": " + nums.sample());
		}

		StdOut.println();

		// Test dequeue functionality
		StdOut.println("Dequeueing the entire queue...");
		StdOut.print("Queue: [\t");
		for (int i = 0; i < N; ++i) {
			StdOut.print(nums.dequeue() + "\t");
		}
		StdOut.println("]");
	}
}
