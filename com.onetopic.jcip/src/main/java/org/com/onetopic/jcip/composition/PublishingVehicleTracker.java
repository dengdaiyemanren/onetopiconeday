package org.com.onetopic.jcip.composition;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.com.onetopic.jcip.annotations.ThreadSafe;

/**
 * PublishingVehicleTracker
 * <p/>
 * Vehicle tracker that safely publishes underlying state
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class PublishingVehicleTracker
{
    private final Map<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;
    
    public PublishingVehicleTracker(Map<String, SafePoint> locations)
    {
        this.locations = new ConcurrentHashMap<String, SafePoint>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }
    
    public Map<String, SafePoint> getLocations()
    {
        return unmodifiableMap;
    }
    
    public SafePoint getLocation(String id)
    {
        return locations.get(id);
    }
    
    public void setLocation(String id, int x, int y)
    {
        if (!locations.containsKey(id))
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        locations.get(id).set(x, y);
    }
    
}
