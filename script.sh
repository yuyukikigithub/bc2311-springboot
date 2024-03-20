# Remove all containers
docker rm $(docker ps -a -q)
# Remove all docker images
docker rmi $(docker images -q)

# recompile all jars and rebuild docker images
cd bc-crypto-coingecko
mvn clean install
docker build -t bc-crypto-coingecko:0.0.1 -f Dockerfile .
# cd ..
# cd bc-stock-finnhub
# mvn clean install
# docker build -t bc-stock-finnhub:0.0.1 -f Dockerfile .
# cd ..
# cd bc-product-data
# mvn clean install
# docker build -t bc-product-data:0.0.1 -f Dockerfile .
# cd ..
# cd bc-invest-simple
# mvn clean install
# docker build -t bc-invest-simple:0.0.1 -f Dockerfile .
cd ..
# Pull offical postgres and redis docker images
docker pull postgres
docker pull redis