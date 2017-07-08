import { Tasklist.ClientPage } from './app.po';

describe('tasklist.client App', () => {
  let page: Tasklist.ClientPage;

  beforeEach(() => {
    page = new Tasklist.ClientPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
