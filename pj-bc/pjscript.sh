cd bc-crypto-coingecko
mvn clean install
mvn spring-boot:run &

cd ..

cd bc-stock-finnhub
mvn clean install
mvn spring-boot:run &

cd ..

cd bc-product-data
mvn clean install
mvn spring-boot:run 
