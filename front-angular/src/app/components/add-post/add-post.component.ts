import { Component, OnInit } from '@angular/core';
import { Posts } from 'src/app/models/posts.model';
import { PostsService } from 'src/app/service/posts.service';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent implements OnInit {

  post: Posts = {
    title: '',
    body: '',
   
  };
  submitted = false;

  constructor(private postsService: PostsService) { }

  ngOnInit(): void {
  }

  savePost(): void {
    const data = {
      title: this.post.title,
      description: this.post.body
    };

  
    this.postsService.create(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }

  newTutorial(): void {
    this.submitted = false;
    this.post = {
      title: '',
      body: '',
    };
  }  

}
