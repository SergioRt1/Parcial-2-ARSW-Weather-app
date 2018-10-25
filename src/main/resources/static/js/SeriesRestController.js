var WeathersRestController = (function () {
    var url = '';

    function getWeathersAlphavantage(name, type) {
        return axios.get(url+"/Weathers/alphavantage/"+name+"/"+type).then(function (response) {
            return response.data;
        })
    }

    function getWeathersIntervalAlphavantage(name, type, interval) {
        return axios.get(url+"/Weathers/alphavantage/"+name+"/"+type+"/"+interval).then(function (response) {
            return response.data;
        })
    }

    function getWeathersIextrading(name, type) {
        return axios.get(url+"/Weathers/iextrading/"+name+"/"+type).then(function (response) {
            return response.data;
        })
    }

    function getWeathersDateIextrading(name, type, date) {
        return axios.get(url+"/Weathers/iextrading/"+name+"/"+type+"/"+date).then(function (response) {
            return response.data;
        })
    }



    return {
        getWeathersAlphavantage: getWeathersAlphavantage,
        getWeathersIntervalAlphavantage: getWeathersIntervalAlphavantage,
        getWeathersIextrading: getWeathersIextrading,
        getWeathersDateIextrading: getWeathersDateIextrading

    };
})();