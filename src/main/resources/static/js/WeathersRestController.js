var WeathersController = (function () {

    function clearTables() {
        var content = document.getElementById("content");
        var tables = document.getElementsByClassName("table");
        while (tables.length > 0) {
            content.removeChild(tables[0]);
        }
        var titles = document.getElementsByClassName("table-title");
        while (titles.length > 0) {
            content.removeChild(titles[0]);
        }
    }


    function addWeathers(Weathers) {
        var tableOrder = document.createElement("table");
        var header = document.createElement("tr");

        var cell = document.createElement("th");
        cell.innerHTML = "Wind";
        header.appendChild(cell);

        var cell = document.createElement("th");
        cell.innerHTML = "Cloudiness";
        header.appendChild(cell);

        var cell = document.createElement("th");
        cell.innerHTML = "Pressure";
        header.appendChild(cell);

        var cell = document.createElement("th");
        cell.innerHTML = "Humidity";
        header.appendChild(cell);

        var cell = document.createElement("th");
        cell.innerHTML = "Sunrise";
        header.appendChild(cell);

        var cell = document.createElement("th");
        cell.innerHTML = "Sunset";
        header.appendChild(cell);

        var cell = document.createElement("th");
        cell.innerHTML = "Geo coords";
        header.appendChild(cell);


        tableOrder.appendChild(header);

        tableOrder.setAttribute("class", "table");
        for (i in Weathers) {
            var row = document.createElement("tr");

            var cell = document.createElement("td");
            cell.innerHTML = Weathers[i].date;
            row.appendChild(cell);

            var cell = document.createElement("td");
            cell.innerHTML = Weathers[i].open;
            row.appendChild(cell);

            var cell = document.createElement("td");
            cell.innerHTML = Weathers[i].high;
            row.appendChild(cell);

            var cell = document.createElement("td");
            cell.innerHTML = Weathers[i].low;
            row.appendChild(cell);

            var cell = document.createElement("td");
            cell.innerHTML = Weathers[i].close;
            row.appendChild(cell);

            var cell = document.createElement("td");
            cell.innerHTML = Weathers[i].volume;
            row.appendChild(cell);

            tableOrder.appendChild(row);
        }
        var title = document.createElement("h4");
        title.setAttribute("class", "table-title");
        title.innerHTML = "Table";
        var firstTable = document.getElementById("HTMLtable");
        content.insertBefore(tableOrder, firstTable);
        content.insertBefore(title, tableOrder);
    }

    function getSelected(id) {
        var selectedTable = document.getElementById(id);
        var tableLabel = selectedTable.options[selectedTable.selectedIndex].value;
        return tableLabel;
    }


    function loadWeathers(WeatherBuilder, filterSource) {
        clearTables();
        loadData(WeatherBuilder, filterSource);
    }

    function WeatherAlphavantageBuilder(Weathers) {
        var WeathersBuild = [];
        var cont = 0;
        var TimeWeathers;
        for(v in Weathers){
            if(cont++ === 1){
                TimeWeathers = v;
            }
        }
        for (i in Weathers[TimeWeathers]) {
            var Weather = {date: i, open: Weathers[TimeWeathers][i]["1. open"], high: Weathers[TimeWeathers][i]["2. high"], low: Weathers[TimeWeathers][i]["3. low"], close: Weathers[TimeWeathers][i]["4. close"], volume: Weathers[TimeWeathers][i]["5. volume"]};
            WeathersBuild.push(Weather);
        }
        addWeathers(WeathersBuild);
    }

    function loadData(callback, filterSource) {
        axios.all([filterSource()])
                .then(axios.spread(function (Weather) {
                    callback(Weather);
                }));
    }

    function filterSelected() {
        var city = document.getElementById("city").value;
        return WeathersRestController.getWeathersAlphavantage(city);
    }


    return {
        loadWeathers: loadWeathers,
        filterSelectedIextrading: filterSelectedIextrading,
        filterSelectedAlphavantage: filterSelectedAlphavantage,
        WeatherIextradingBuilder: addWeathers
    };
})();