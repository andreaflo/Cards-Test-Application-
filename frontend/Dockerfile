FROM node:20-alpine

WORKDIR /app

# 1. Copia i file delle dipendenze
# Docker li cercherà nella cartella dove lanci il comando build
COPY package*.json ./

# 2. Installa le dipendenze
RUN npm install

# 3. Copia tutto il resto (src, public, card-app, ecc.)
COPY . .

EXPOSE 3000

CMD ["npm", "start"]
