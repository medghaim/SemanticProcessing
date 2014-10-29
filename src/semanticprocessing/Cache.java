package semanticprocessing;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Contains various functions that facilitate the creation and management of
 * a 'cache'.
 * @author Isiah Malit and Vera Rizvi
 * edited by Hussam Kaka
 */
public class Cache implements Iterable<FacultyMember>, Serializable {

    /** The cache. */
    private ArrayList<FacultyMember> members;

    /** URLs queued for caching. */
    private ArrayList<URL> pendingURLs;

    /** URLs of cached pages. Must remain in sync with members ArrayList. */
    private ArrayList<URL> readURLs;

    /**
     * Creates a new instance of a cache.
     */
    public Cache() {
        members = new ArrayList<FacultyMember>();
        pendingURLs = new ArrayList<URL>();
        readURLs = new ArrayList<URL>();
    }

    /**
     * Adds a URL to the list of pending URLs if it has not been cached and
     * it is not in already in the list. Otherwise does nothing.
     * If the URL is successfully added, the function returns <code>true</code>
     * - otherwise, it returns <code>false</code>.
     * @param url The url that will be added to the list of pending URLs.
     * @return <code>true</code> if the given URL is added to the list, false
     * otherwise.
     */
    public final boolean add(final URL url) {
        if (pendingURLs.contains(url) || readURLs.contains(url)) {
            return false;
        }
        pendingURLs.add(url);
        return true;
    }


    /**
     * Returns true if the item at the specified element is removed from
     * the cache.
     * @param itemIndex The index from which the item is removed.
     * @return <code>true</code> if the item at <code>int itemIndex</code>
     * was successfully removed from the <code>ArrayList<FacultyMember>
     * members</code> list.
     */
    private boolean remove(final int itemIndex) {
        if (itemIndex < 0 || itemIndex >= size()) {
            return false;
        } else {
            members.remove(itemIndex);
            readURLs.remove(itemIndex);
            return true;
        }
    }

    /**
     * Tests the indicated URL for its cache status.
     * @param url The URL to test.
     * @return 1 if cached, 0 if pending, and -1 if neither.
     */
    public int isCached(final URL url){
        if(readURLs.contains(url))
            return 1;
        else if(pendingURLs.contains(url))
            return 0;
        else
            return -1;
    }
    
    /**
     * Removes the given URL from cache or the list of Pending URL assuming
     * it exists in one of them. Otherwise does nothing.
     * @param url The URL instance that is to be removed.
     * @return <code>true</code> If the given URLs is found and removed, false
     * otherwise.
     */
    public final boolean remove(final URL url) {
        if (pendingURLs.remove(url)) {
            return true;
        }
        int index = readURLs.indexOf(url);
        return remove(index);
    }

    /**
     * An <code>int</code> return of the number of cached members.
     * @return The number of members in the cache.
     */
    public final int size() {
        return members.size();
    }

    /**
     * Gets the number of URLs in the queue to be cached.
     * @return The number of pending URLs.
     */
    public final int getNumberOfPendingUrls() {
        return pendingURLs.size();
    }

    /**
     * Returns true if the pendingURLs contains the specified URL.
     * @param url The URL to look for.
     * @return True if it is contained within pendingURLs, false otherwise.
     */
    public final boolean urlQueueContains(final URL url) {
        return pendingURLs.contains(url);
    }

    /**
     * Returns the FacultyMember instance at the specified index. Can only
     * return cached members. Throws IndexOutOfBoundsException if any
     * nonexistent index is passed.
     * @param i The index at which to search the ArrayList.
     * @return The FacultyMember instance at the indicated element.
     */
    public final FacultyMember get(final int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return members.get(i);
        }
    }

    /**
     * Returns <code>true</code> if no members have been cached.
     *@return <code>true</code> if no members have been cached.
     */
    public final boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns <code>true</code> if there are no remaining instances of URLs
     * in the queue of URLs yet to be cached.
     * @return <code>true</code> if no URLs remain in <code>URLqueue</code>.
     */
    public final boolean pendingURLsIsEmpty() {
        return pendingURLs.isEmpty();
    }

   /**
     * Returns an <code>ArrayList<URL></code> which contains the URLs yet to be
     * queued.
     * @return <Code>pendingURLs</code> - a list of pending URLs.
     */
    public final ArrayList<URL> getPendingURLs() {
        return (ArrayList<URL>) pendingURLs.clone();
    }

    /**
     * Returns the URLs of the main pages of FacultyMembers that are cached.
     * @return Main page URLs of cached faculty members.
     */
    public final ArrayList<URL> getCachedURLs() {
        return (ArrayList<URL>) readURLs.clone();
    }
    /**
     * Clears the list list of pending URLs.
     */
    public final void clearPendingURLs() {
        pendingURLs = new ArrayList<URL>();
    }

    /**
     * Clears all the elements of this cache.
     */
    public final void clearCache() {
        members = new ArrayList<FacultyMember>();
        readURLs = new ArrayList<URL>();
        pendingURLs = new ArrayList<URL>();
    }

    /**
     * Return an <code>iterator</code> that iterates over the cached
     * information.
     * @return an iterator that iterates over the cache.
     */
    public final Iterator<FacultyMember> iterator() {
        return new CacheIterator(this);
    }

    /**
     * Adds any pending URLs to cache.
     * @return A hash map containing URLs that caused errors as keys and
     * the exceptions returned as values.
     */
    public final HashMap<URL, Exception> generateCache() {
        HashMap<URL, Exception> invalidURLs = new HashMap<URL, Exception>();
        if (pendingURLs.isEmpty()) {
            return invalidURLs;
        }

        for (URL url : pendingURLs) {
            try {
                FacultyMember member = new FacultyMember(url);
                readURLs.add(url);
                members.add(member);

            } catch (IOException ex) {
                invalidURLs.put(url, ex);
            } catch (NotAnHtmlUrlException ex) {
                invalidURLs.put(url, ex);
            }
        }

        clearPendingURLs();
        return invalidURLs;
    }

    /**
     * The Cache iterator that is to traverse through <code>FacultyMember</code>
     * objects.
     * @param <FacultyMember> The type of object that we are to iterate.
     */
    public class CacheIterator<FacultyMember> implements
            Iterator<FacultyMember> {

        /** The cache being iterated over. */
        private Cache list;
        /** The index of the next item to return. */
        private int position;
        /** Whether remove has been called at the current next call. */
        private boolean removeCalled;

        /**
         * Create an iterator over the given cache.
         * @param cache The instance for which an iterator is to be created.
         */
        public CacheIterator(final Cache cache) {
            this.list = cache;
            position = 0;
            removeCalled = false;
        }

        /**
         * Returns true if there are any items remaining in the cache.
         * @return <code>true</code> if there are items left in the cache.
         */
        public boolean hasNext() {
            return (position < size());
        }

        /**
         * Return the next item in the cache. If there are no remainder items,
         * throw a <code>NoSuchElementException</code>.
         * @return The next item in the cache.
         */
        public FacultyMember next() {
            if (this.hasNext()) {
                FacultyMember member = (FacultyMember)
                        list.members.get(position);
                position++;
                removeCalled = false;
                return member;

            } else {
                throw new NoSuchElementException("no element");
            }
        }

        /**
         * Remove from the underlying collection the last element returned by
         * the iterator. This method may only be called once per call to next.
         */
        public void remove() {

            if (removeCalled) {
                    throw new IllegalStateException("");
            }
            list.remove(position - 1);
            position--;
        }
    }
}
