// craco.config.js
const hostUrl = process.env.REACT_APP_API_URL;
module.exports = {
    devServer: {
      proxy: {
        '/api': { // /api
          target: hostUrl,
          changeOrigin: true,
          secure: false,
        },
      },
    },
  };
  