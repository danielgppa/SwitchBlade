import IOCard from "../components/IOCard"
import { whatIsThePercentageOf, valueIsWhatPercentageOf, percentageDecrease, percentageIncrease,
         increaseByPercentage, decreaseByPercentage, initialIncreasedByPercentage, initialDecreasedByPercentage } from "../api/calc/apiFetchPercentage"

function Calculators() {

    return (
        <div>
            <h1>Percentage Calculators</h1>
            <IOCard name='Percentage of value' calculationFunction={whatIsThePercentageOf}></IOCard>
            <IOCard name='Value is percentage of' calculationFunction={valueIsWhatPercentageOf}></IOCard>
            <IOCard name='Percentage increase' calculationFunction={percentageIncrease}></IOCard>
            <IOCard name='Percentage decrease' calculationFunction={percentageDecrease}></IOCard>
            <IOCard name='Increase by percentage' calculationFunction={increaseByPercentage}></IOCard>
            <IOCard name='Decrease by percentage' calculationFunction={decreaseByPercentage}></IOCard>
            <IOCard name='Value increased by percentage' calculationFunction={initialIncreasedByPercentage}></IOCard>
            <IOCard name='Value decreased by percentage' calculationFunction={initialDecreasedByPercentage}></IOCard>
        </div>
    )
}

export default Calculators