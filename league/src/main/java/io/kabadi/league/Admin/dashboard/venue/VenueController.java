package io.kabadi.league.Admin.dashboard.venue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/admin")
@CrossOrigin
public class VenueController {
    
    @Autowired
    private VenueRepository vrepo;

    @GetMapping("/getVenue")
    public List<Venue> getVenue(){
        return vrepo.findAll();
    }

    @PostMapping("/addVenue")
    public Venue postMethodName(@RequestBody Venue venue) {
        return vrepo.save(venue);
    }

    @DeleteMapping("/deleteVenue/{id}")
    public Long deleteVenue(@PathVariable Long id){
        vrepo.deleteById(id);
        return id;
    }

    @PutMapping("/editVenue/{id}")
    public Venue editVenue(@RequestBody Venue venue,@PathVariable Long id){
        Venue vvenue=new Venue();
        vvenue.setId(id);
        vvenue.setVenueName(venue.getVenueName());
        vvenue.setVenueImageURL(venue.getVenueImageURL());
        vvenue.setVenueDescription(venue.getVenueDescription());
        vvenue.setVenueLocation(venue.getVenueDescription());
        return vrepo.save(vvenue);
    }
    
}
