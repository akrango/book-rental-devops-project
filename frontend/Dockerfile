FROM node:18 as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:1.25.1
COPY --from=build /app/build /usr/share/nginx/html

RUN rm /etc/nginx/conf.d/default.conf
CMD ["sh", "-c", "echo 'server { listen 80; location /react { alias /usr/share/nginx/html/; try_files $uri /react/index.html; } }' > /etc/nginx/conf.d/default.conf && nginx -g 'daemon off;'"]
