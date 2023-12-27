import ClickableCard from "../components/ClickableCard"

function MainScreen() {

    return (
        <div>
            <ClickableCard name='Calculators' route='/calc'/>
            <ClickableCard name='Generators' route='/gen'/>
        </div>
    )
}

export default MainScreen