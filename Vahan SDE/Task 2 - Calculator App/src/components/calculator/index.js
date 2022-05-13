import React from "react";
import "./index.css";

export default function Calculator() {
	const [counter, setValue] = React.useState(() => 0); // Set the value immediately.
	const [result, setResult] = React.useState(null);
	const [operationString, setOperationString] = React.useState("+");

	const input1 = React.useRef();
	const input2 = React.useRef();

	var inp1Val, inp2Val;

	const evaluate = ({ operation }) => {
		inp1Val = parseInt(input1?.current?.value || 0);
		inp2Val = parseInt(input2?.current?.value || 0);
		switch (operation) {
			case "add":
				setResult(inp1Val + inp2Val);
				setOperationString("+");
				break;
			case "sub":
				setOperationString("-");
				setResult(inp1Val - inp2Val);
				break;
			case "mul":
				setOperationString("*");
				setResult(inp1Val * inp2Val);
				break;
			case "div":
				setOperationString("/");
				setResult(inp1Val / inp2Val);
				break;
			default:
				return;
		}
	};

	const incrementCounter = ({ mode = "incr", operation }) => {
		switch (mode) {
			case "incr":
				setValue((prevState) => prevState + 1);
				evaluate({ operation });
				break;
			case "reset":
				// Reset inputs to null
				input1.current.value = null;
				input2.current.value = null;
				setValue(() => 0);
				setOperationString(() => "+");
				setResult(null);
				break;
			default:
				return;
		}
	};

	return (
		<div className="layout-column align-items-center">
			<div
				data-testid="total-operations"
				className="pt-50 total-operations"
			>
				Total operations performed: {counter}
			</div>
			<div className="card">
				<section className="card-text">
					<div className="layout-row justify-content-around align-items-center mt-40">
						<input
							type="number"
							className="ml-3 mr-3"
							data-testid="app-input1"
							autoComplete="off"
							placeholder="Eg: 1"
							name="input1"
							ref={input1}
						/>
						<label
							className="ml-2 mr-2 symbol text-center"
							data-testid="selected-operator"
						>
							{operationString}
						</label>
						<input
							type="number"
							data-testid="app-input2"
							autoComplete="off"
							className="ml-3 mr-3"
							placeholder="Eg: 2"
							name="input2"
							ref={input2}
						/>
					</div>

					<div className="layout-row justify-content-around mt-30">
						<button
							className="operationFont"
							type="submit"
							data-testid="addButton"
							onClick={() =>
								incrementCounter({
									mode: "incr",
									operation: "add",
								})
							}
						>
							+
						</button>
						<button
							className="operationFont"
							type="submit"
							data-testid="subtractButton"
							onClick={() =>
								incrementCounter({
									mode: "incr",
									operation: "sub",
								})
							}
						>
							-
						</button>
						<button
							className="operationFont"
							type="submit"
							data-testid="multiplyButton"
							onClick={() =>
								incrementCounter({
									mode: "incr",
									operation: "mul",
								})
							}
						>
							*
						</button>
						<button
							className="operationFont"
							type="submit"
							data-testid="divideButton"
							onClick={() =>
								incrementCounter({
									mode: "incr",
									operation: "div",
								})
							}
						>
							/
						</button>
					</div>

					<div className="layout-row justify-content-between align-items-center mt-30">
						<button
							type="reset"
							data-testid="resetButton"
							className="outline danger"
							onClick={() => incrementCounter({ mode: "reset" })}
						>
							Reset
						</button>
						{result !== null && (
							<div className="layout-row justify-content-center align-items-center result-container">
								<div
									data-testid="result"
									className="result-value ma-0 slide-up-fade-in"
								>
									Result: {result}
								</div>
							</div>
						)}
					</div>
				</section>
			</div>
		</div>
	);
}
