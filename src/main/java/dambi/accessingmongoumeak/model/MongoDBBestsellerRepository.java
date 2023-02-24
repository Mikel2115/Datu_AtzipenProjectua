package dambi.accessingmongoumeak.model;

import java.util.ArrayList;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBBestsellerRepository implements BestsellerRepository {
    private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                            .readPreference(ReadPreference.primary())
                                                                            .readConcern(ReadConcern.MAJORITY)
                                                                            .writeConcern(WriteConcern.MAJORITY)
                                                                            .build();
    
    @Autowired
    private MongoClient client;
    private MongoCollection<Bestseller> bestsellerCollection;

    @PostConstruct
    void init(){
        bestsellerCollection = client.getDatabase("Bideojokoak").getCollection("BestSeller", Bestseller.class);
    }

    @Override
    public List<Bestseller> findAll(){
        return bestsellerCollection.find().into(new ArrayList<>());
    }

    @Override
    public Bestseller findById(int id){
       return bestsellerCollection.find(Filters.eq("_id", id)).first();
    }

    @Override
    public Bestseller findByRango(int rango){
        return bestsellerCollection.find(Filters.eq("RANGO", rango)).first();
    }

    @Override
    public List <Bestseller> findByPublicador(String publi){
        return bestsellerCollection.find(Filters.eq("PUBLICADOR", publi)).into(new ArrayList<>());
    }

    @Override
    public Bestseller updateRango(Bestseller bestseller){
        bestsellerCollection.updateOne(Filters.eq(bestseller.getId()), 
            new Document("$set", new Document("rango", bestseller.getRango())).append("ventas", bestseller.getVentas()));
        
        return bestseller;
    }

    @Override
    public Bestseller save(Bestseller bideojokoa) {
        bestsellerCollection.insertOne(bideojokoa);
        return bideojokoa;
    }

    @Override
    public long delete(int id) {
        return bestsellerCollection.deleteOne(new Document("_id", id)).getDeletedCount();
    }
    
}
