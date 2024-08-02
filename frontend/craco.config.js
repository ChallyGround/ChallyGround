// craco.config.js
module.exports = {
    devServer: {
      proxy: {
        '/api': { // /api
          target: 'http://49.174.231.190:8080',
          changeOrigin: true,
          secure: false,
        },
      },
    },
  };
  