FROM node:20-alpine

# Se il Dockerfile è dentro la cartella 'frontend'
WORKDIR /app
COPY package*.json ./
RUN npm install
# Copia tutto il contenuto della cartella frontend nel container
COPY . .
RUN npm run build
