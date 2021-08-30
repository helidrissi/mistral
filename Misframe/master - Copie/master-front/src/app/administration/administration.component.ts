import {HttpClient} from '@angular/common/http';
import {Component, OnInit} from '@angular/core';
import {Validators} from '@angular/forms';
import {FormControl, FormGroup} from '@angular/forms';
import {AccountService} from '../services/account.service';
import {TokenService} from '../services/token.service';

@Component({
  selector: 'app-administration',
  templateUrl: './administration.component.html',
  styleUrls: ['./administration.component.css']
})
export class AdministrationComponent implements OnInit {

  userInfos: any;
  envir: any;

  constructor(private account: AccountService, private token: TokenService, private httpClient: HttpClient) {
  }

  showMsgA: boolean = false;
  showMsgL: boolean = false;
  selectedFile: File;

  retrievedImage: any;

  base64Data: any;

  retrieveResonse: any;

  message: string;

  imageName: any;


  //Gets called when the user selects an image
  formUsers = new FormGroup({
    file: new FormControl('', [Validators.required]),


  })


  public onFileChanged(event) {

    //Select File

    this.selectedFile = event.target.files[0];

  }

  //Gets called when the user clicks on submit to upload the image

  onUpload() {

    console.log(this.selectedFile);
    this.showMsgA = true;
    this.showMsgL = false;
    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.

    const uploadImageData = new FormData();

    uploadImageData.append('imageFile', this.selectedFile, this.userInfos.id);

    //Make a call to the Spring Boot Application to save the image

    this.httpClient.post('http://localhost:8080/image/upload', uploadImageData, {observe: 'response'})

      .subscribe((response) => {

          if (response.status === 200) {

            this.message = 'Image uploaded successfully';

          } else {

            this.message = 'Image not uploaded successfully';

          }

        }
      );

  }

  onUpload2() {

    console.log(this.selectedFile);
    this.showMsgL = true;
    this.showMsgA = false;
    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.

    const uploadImageData = new FormData();

    uploadImageData.append('imageFile', this.selectedFile, this.envir);

    //Make a call to the Spring Boot Application to save the image

    this.httpClient.post('http://localhost:8080/image/upload', uploadImageData, {observe: 'response'})

      .subscribe((response) => {

          if (response.status === 200) {

            this.message = 'Image uploaded successfully';

          } else {

            this.message = 'Image not uploaded successfully';

          }

        }
      );

  }


  //Gets called when the user clicks on retieve image button to get the image from back end


  ngOnInit(): void {
    $(document).ready(function () {

    })

    this.account.authStatus.subscribe(
      res => {
        this.userInfos = this.token.getInfos();
        this.envir = this.token.getEnv();
      }
    )
  }
}
