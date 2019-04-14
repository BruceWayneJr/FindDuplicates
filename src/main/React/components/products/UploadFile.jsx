import React from 'react'

export default class UploadFile extends React.Component {
    constructor() {
        super();
        this.state = {
          csvfile: undefined
        };
        this.handleChange = this.handleChange.bind(this);
        this.importCSV = this.importCSV.bind(this);
      }
    
      handleChange(event){
        this.setState({
          csvfile: event.target.files[0]
        });
      };
    
      importCSV (){
        this.props.saveFile(this.state.csvfile)
      };
    
      render() {
        return (
          <div className="App">
            <h2>Upload CSV File!</h2>
            <input
              className="csv-input"
              type="file"
              accept=".csv"
              ref={input => {
                this.filesInput = input;
              }}
              name="file"
              placeholder={null}
              onChange={this.handleChange}
            />
            <p />
            <button className="btn btn-fill btn-primary" onClick={this.importCSV}>Upload</button>
          </div>
        );
      }
}