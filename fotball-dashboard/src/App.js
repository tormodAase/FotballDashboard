import Table from './TableComponent';
import Container from './ContainerComponent';

function App() {
  let testArray = [
    [<p>Name</p>, <p>Country</p>, <p>Age</p>],
    ["Tormod", "Norway"],
    ["Marcel", "Switzerland", "25"],
    ["Tormod", "1 - 2", "Marcel"]
  ]

  return (
    <div className="App">
      <Container title="Tabell"><Table array={testArray}/></Container>
    </div>
  );
}

export default App;
