public class MongoFilter {



    public static void main(String[] args) {



        try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {



            var database = mongoClient.getDatabase("testdb");



            MongoCollection<Document> collection = database.getCollection("cars");



            FindIterable fit = collection.find(and(lt("price", 50000),

                    gt("price", 20000))).sort(new Document("price", -1));



            var docs = new ArrayList<Document>();



            fit.into(docs);



            for (Document doc : docs) {



                System.out.println(doc);

            }

        }

    }

}