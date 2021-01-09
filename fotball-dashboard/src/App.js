import Table from './TableComponent';
import Container from './ContainerComponent';
import Team from './TeamComponent';
import react, {useState} from 'react';
import TopBar from './TopBarComponent';

function App() {
  let testArrayT = [[<p>Logo</p>, <p>Team</p>, <p>Country</p>]
  ]

  let testArrayL = [[<p>Name</p>, <p>Type</p>, <p>Logo</p>, <p>Country</p>]];

  let [teams, setTeams] = useState([["Loading"]]);
  let [leagues, setLeagues] = useState([["Loading"]]);


  var requestOptions = {
    method: 'GET',
    redirect: 'follow'
  };

  console.log(teams);
  
  if (teams.length < 2) {
    fetch("http://localhost:8080/getAllTeams", requestOptions)
      .then(response => response.json())
      .then(result => {
        let newArray = testArrayT;
        for (let i=0; i<result.length; i++) {
          let logo = <img src={result[i].logo} />;
          let name = <p>{result[i].name}</p>;
          let flag = <p>{result[i].country}</p>;
          newArray.push([logo, name, flag]);
          console.log(i);
        }
        setTeams(newArray);
      })
      .catch(error => {
        console.log('error', error);
        setTeams([[<div className="ErrorMessage">{error.toString()+"\n(Please contact Tormod for assistance)"}</div>]])
      });
  }

  if (leagues.length < 2) {
    fetch("http://localhost:8080/getAllLeagues", requestOptions)
      .then(response => response.json())
      .then(result => {
        let newArray = testArrayL;
        for (let i=0; i<result.length; i++) {
          let name = <p>{result[i].name}</p>;
          let type = <p>{result[i].type}</p>;
          let logo = <img src={result[i].logo}/>;
          let country = <img src={result[i].country.flag} />
          newArray.push([name, type, logo, country]);
          console.log(i);
        }
        setLeagues(newArray);
      })
      .catch(error => {
        console.log('error', error);
        setLeagues([[<div className="ErrorMessage">{error.toString()+"\n(Please contact Tormod for assistance)"}</div>]])
      });
  }

  return (
    <div className="App">
      <TopBar />
      <Container title="Tabell"><Table array={teams}/></Container>
      <Container title="Tabell"><Table array={leagues}/></Container>
    </div>
  );
}

export default App;
